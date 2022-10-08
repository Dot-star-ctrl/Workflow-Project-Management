<template>
  <v-app-bar v-if="showAppBar" background="#BBC2C8" prominent>
    <v-app-bar-nav-icon
      variant="text"
      @click.stop="showDrawer"
    ></v-app-bar-nav-icon>
  </v-app-bar>
  <v-navigation-drawer v-model="drawer" position="left">
    <div class="d-flex align-center mt-8 mb-5 ml-3">
      <img src="@/assets/logo.png" height="70" />
      <h2 class="pl-3 font-weight-medium">Workflow</h2>
    </div>

    <v-list nav class="mb-10 ml-8 mt-10">
      <router-link :to="'/dashboard'" class="text-decoration-none text-black">
      <v-list-item value="dashboard">
            <v-icon
              class="ml-2"
              color="#4a5567"
              icon="fa-solid fa-house"
            />
            <p class="ml-6">Dashboard</p>
      </v-list-item>
      </router-link>
      <router-link :to="'/workspaces'" class="text-decoration-none text-black">
      <v-list-item value="workspace">
            <v-icon
              class="ml-2"
              large
              color="#4a5567"
              icon="fa-solid fa-building"
            />
            <p class="ml-6">Workspaces</p>
      </v-list-item>
      </router-link>
      <router-link :to="'/users'" class="text-decoration-none text-black">
      <v-list-item value="users">
            <v-icon
              class="ml-2"
              large
              color="#4a5567"
              icon="fa-solid fa-user"
            />
            <p class="ml-6">Users</p>
      </v-list-item>
    </router-link>
    </v-list>
    <v-divider class="mx-8"></v-divider>
    <v-list nav class="mb-10 ml-8 mt-10">
      <v-list-item value="settings">
            <v-icon
              class="ml-2"
              large
              color="#4a5567"
              icon="fa-solid fa-gear"
            />
            <p class="ml-6">Settings</p>
      </v-list-item>
      <v-list-item value="home">
            <v-icon
              class="ml-2"
              large
              color="#4a5567"
              icon="fa-solid fa-bell"
            />
            <p class="ml-6">Notifications</p>
      </v-list-item>
    </v-list>
    <v-divider v-if="showAppBar && drawer" class="pt-10 mx-8"></v-divider>
    <v-list v-if="showAppBar && drawer" class="ml-6">
      <v-list-item
        prepend-avatar="https://randomuser.me/api/portraits/women/75.jpg"
        title="Jane Doe"
        subtitle="User"
      >
      </v-list-item>
      <v-list-item>
        <template v-slot:prepend>
          <v-icon class="ml-2" large color="#4a5567" icon="fa-solid fa-bell" />
          <p class="ml-6">Notifications</p>
        </template>
      </v-list-item>
      <v-list-item>
        <template v-slot:prepend>
          <v-icon
            class="ml-2"
            large
            color="#4a5567"
            icon="fas fa-solid fa-right-from-bracket"
          />
          <p class="ml-6">Log out</p>
        </template>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
import { ref } from "vue";
import { showAppBar } from "@/utils/DisplayHelper";

let drawer = ref(true);
const showDrawer = () => {
  drawer.value = !drawer.value;
};
</script>
