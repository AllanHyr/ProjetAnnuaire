<template>
  <q-page v-if="pageLoaded" class="items-center justify-evenly">
    <div class="row justify-center q-my-xl">
      <q-input
        class="col-4"
        v-model="rechercheNom"
        label="Rechercher par nom"
      ></q-input>
      <q-select
        class="col-2"
        v-model="selectedSite"
        :options="siteOptions"
        emit-value
        map-options
        label="Sélectionner un site"
        option-value="id"
        option-label="label"
      />
      <q-select
        class="col-2"
        v-model="selectedService"
        :options="serviceOptions"
        emit-value
        map-options
        label="Sélectionner un service"
        option-value="id"
        option-label="label"
      />
    </div>
    <div class="q-mx-xl">
      <q-table
        :rows="data"
        :columns="columns"
        row-key="name"
        :loading="!dataLoaded"
      />
    </div>
    <q-page class="flex flex-center">
      <q-card class="max-w-sm shadow-2">
        <q-card-section class="q-pa-md">
          <div class="text-h6 text-center">Connexion</div>

          <q-form @submit="login">
            <q-input
              filled
              v-model="username"
              label="Nom d'utilisateur"
              dense
            />

            <q-input
              filled
              v-model="password"
              label="Mot de passe"
              type="password"
              dense
            />

            <q-btn
              type="submit"
              color="primary"
              class="full-width q-mt-md"
              label="Se connecter"
              dense
            />
          </q-form>
        </q-card-section>
      </q-card>
    </q-page>
    <q-dialog
      v-model="errorPassword"
      transition-show="rotate"
      transition-hide="rotate"
    >
      <q-card>
        <q-card-section>
          <div class="text-h6">Mot de passe incorrect</div>
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="Ok" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </q-page>
  <q-page v-else class="row items-center justify-evenly">
    Chargement...
  </q-page>
</template>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';
import { api } from 'boot/axios';

const data = ref(null);
const rechercheNom = ref(null);
const idService = ref(null);
const idSite = ref(null);
const dataLoaded = ref(false);
const pageLoaded = ref(false);
const username = ref(null);
const password = ref(null);
const errorPassword = ref(false);
const authentification = ref(false);

const selectedService = ref(null);
const selectedSite = ref(null);

const columns = [
  {
    name: 'nom',
    required: true,
    label: 'Nom',
    align: 'left',
    field: (row) => row.nom,
    sortable: true,
  },
  {
    name: 'prenom',
    align: 'left',
    label: 'Prénom',
    field: (row) => row.prenom,
    sortable: true,
  },
  {
    name: 'telephoneFixe',
    align: 'left',
    label: 'Téléphone Fixe',
    field: (row) => row.telephoneFixe,
    sortable: true,
  },
  {
    name: 'telephonePortable',
    align: 'left',
    label: 'Téléphone Portable',
    field: (row) => row.telephonePortable,
    sortable: true,
  },
  {
    name: 'ville',
    align: 'left',
    label: 'Ville',
    field: (row) => row.ville,
    sortable: true,
  },
  {
    name: 'attribution',
    align: 'left',
    label: 'Attribution',
    field: (row) => row.attribution,
    sortable: true,
  },
  {
    name: 'service',
    align: 'left',
    label: 'Service',
    field: (row) => row.service,
    sortable: true,
  },
  {
    name: 'action',
    align: 'center',
    label: 'Action',
    field: 'action',
  },
];

const serviceOptions = [
  { id: null, label: 'Tous' },
  { id: 1, label: 'Comptabilité' },
  { id: 2, label: 'Production' },
  { id: 3, label: 'Accueil' },
  { id: 4, label: 'Informatique' },
  { id: 5, label: 'Commercial' },
  { id: 6, label: 'Transport' },
  { id: 7, label: 'Juridique' },
];

const siteOptions = [
  { id: null, label: 'Tous' },
  { id: 1, label: 'Paris' },
  { id: 2, label: 'Nantes' },
  { id: 3, label: 'Toulouse' },
  { id: 4, label: 'Nice' },
  { id: 5, label: 'Lille' },
];

onMounted(() => {
  loadData();
});

function login() {
  if (username.value == 'admin' && password.value == 'lemotdepassedelamort') {
    authentification.value = true;
  } else {
    errorPassword.value = true;
  }
}

async function loadData() {
  try {
    const response = await api.get('/all', {
      params: {
        nom: rechercheNom.value,
        service: idService.value,
        site: idSite.value,
      },
    });
    data.value = response.data;
    dataLoaded.value = true;
    pageLoaded.value = true;
  } catch (error) {
    console.log('Erreur :', error);
  }
}

watch(rechercheNom, () => {
  dataLoaded.value = false;
  loadData();
});

watch(selectedSite, () => {
  idSite.value = selectedSite.value === null ? null : selectedSite.value;
  dataLoaded.value = false;
  loadData();
});

watch(selectedService, () => {
  idService.value =
    selectedService.value === null ? null : selectedService.value;
  dataLoaded.value = false;
  loadData();
});
</script>
