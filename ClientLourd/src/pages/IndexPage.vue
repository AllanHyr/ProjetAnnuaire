<template>
  <q-page v-if="pageLoaded" class="row items-center justify-evenly">
    <q-input v-model="rechercheNom"></q-input>
    <q-select
      v-model="selectedSite"
      :options="siteOptions"
      emit-value
      map-options
      label="Sélectionner un site"
      option-value="id"
      option-label="label"
    />
    <q-select
      v-model="selectedService"
      :options="serviceOptions"
      emit-value
      map-options
      label="Sélectionner un service"
      option-value="id"
      option-label="label"
    />
    <q-table
      :rows="data"
      :columns="columns"
      row-key="name"
      :loading="!dataLoaded"
    />
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

const selectedService = ref(null);
const selectedSite = ref(null);

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
