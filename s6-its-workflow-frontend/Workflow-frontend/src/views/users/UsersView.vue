<template>
  <PageComponent title="Users" icon-name="fas fa-solid fa-user">
          <div>
      <div class="d-flex mt-10">
        <div class="searchbar">
        <v-text-field
            variant="outlined"
            placeholder="Search"
            prepend-inner-icon="fa-solid fa-magnifying-glass"
          ></v-text-field>
        </div>
        <v-spacer></v-spacer>
        <router-link
          :to="{ name: 'CreateProject' }"
          class="text-decoration-none"
        >
          <v-btn rounded="outlined" color="#7d4e9a" class="text-white mt-2">
            Add Project
          </v-btn>
        </router-link>
      </div>
      <ProjectsList />
    </div>
  </PageComponent>
</template>

<script setup>
import PageComponent from "@/layouts/PageComponent.vue";
import ProjectsList from "@/components/Project/ProjectsList.vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
</script>