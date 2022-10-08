<template>
  <PageComponent
    title="Workspaces"
    icon-name="fas fa-solid fa-building"
  >
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
          :to="{ name: 'CreateWorkspace' }"
          class="text-decoration-none"
        >
          <v-btn rounded="outlined" color="#7d4e9a" class="text-white mt-2">
            Add Project
          </v-btn>
        </router-link>
      </div>
      <WorkspacesList />
    </div>
  </PageComponent>
</template>

<script setup>
import PageComponent from "@/layouts/PageComponent.vue";
import WorkspacesList from "@/components/Workspace/WorkspacesList.vue";
</script>

<style>
.searchbar {
  width: 250px;
}
</style>