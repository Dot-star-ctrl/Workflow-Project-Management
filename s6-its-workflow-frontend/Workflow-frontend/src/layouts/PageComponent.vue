<template>
  <v-container>
    <div class="d-flex mt-16 mb-5 ml-3">
      <v-icon
       v-if="!$route.name.includes('Dashboard')"
       icon="fas fa-solid fa-angle-left" 
       @click="goBack" 
       class="go-back"
       />
      <v-icon
        small
        color="#7d4e9a"
        :icon="iconName"
        style="--fa-rotate-angle: 30deg"
      />
      <h2 class="pl-3 font-weight-medium">{{ title }}</h2>
    </div>
    <slot></slot>
  </v-container>
</template>

<script setup>
import router from "@/router";

const props = defineProps({
  title: String,
  iconName: String,
});

const goBack = () => {
  router.go(-1);
};
</script>

<style scoped>
.go-back {
  cursor: pointer;
}
</style>