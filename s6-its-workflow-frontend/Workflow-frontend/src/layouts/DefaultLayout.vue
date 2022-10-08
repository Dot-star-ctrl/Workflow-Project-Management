<template>
  <LeftSidebar />
  <div class="d-flex">
  <div class="align-center mt-6 mb-5 ml-10">
    <h3>Today, 24 July</h3>
  </div>
  <v-spacer></v-spacer>
  <div
  v-if="!showAppBar"
   class="d-flex align-center mb-5 ml-3">
<v-icon class="ml-2" large color="#7d4e9a" icon="fa-solid fa-bell" />
        <v-list>
          <v-list-item
            prepend-avatar="https://randomuser.me/api/portraits/women/85.jpg"
            title="Sandra Adams"
            subtitle="Administrator"
            class="profile" 
          >
          
          <v-menu activator="parent">
        <v-list class="profile" >
          <v-list-item>
            <v-list-item-title @click="logout">Log out</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

          </v-list-item>
        </v-list>
  </div>
  </div>
  <v-container>
    <router-view></router-view>
  </v-container>
</template>

<script setup>
import LeftSidebar from "@/components/menu/LeftSidebar.vue";
import { ref, mergeProps } from "vue";
import { showAppBar } from "@/utils/DisplayHelper";
import { useAuth0 } from '@auth0/auth0-vue';

const { logout } = useAuth0();
</script>


<style scoped>
.profile {
  cursor: pointer;
}

</style>