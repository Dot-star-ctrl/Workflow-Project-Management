<template>
  <PageComponent title="Dashboard" icon-name="fa-solid fa-house">
    <!-- <div>
      <div class="d-flex mt-10">
        <div class="searchbar">
          <v-text-field
            variant="outlined"
            placeholder="Search"
            prepend-inner-icon="fa-solid fa-magnifying-glass"
          ></v-text-field>
        </div>
        <v-spacer></v-spacer>

        <v-btn rounded="outlined" color="#7d4e9a" class="text-white mt-2">
          Add Workspace
        </v-btn>
      </div>
    </div> -->
  </PageComponent>
</template>

<script setup>
import PageComponent from "@/layouts/PageComponent.vue";
</script>

<style scoped>
.searchbar {
  width: 250px;
}
</style>