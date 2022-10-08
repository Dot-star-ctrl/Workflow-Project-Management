<template>
<router-link
:to="{ name: 'WorkspaceView', params: { id: ticket.id } }"
  class="text-decoration-none"
>
  <v-card elevation="3" class="ticket pa-5 ma-2 rounded-xl">
    <v-row>
      <v-col class="ticket-id text-center">
        <p>{{ ticket.id }}</p>
      </v-col>
      <v-col cols="6" class="ticket-title text-center">
        <p>{{ ticket.title }}</p>
      </v-col>
      <v-col class="ticket-created-on text-center">
        <div>
            <v-btn rounded="pill" color="#7d4e9a" class="text-white mt-2">
            Edit
          </v-btn>
          <v-btn rounded="pill" color="#7d4e9a" class="text-white mt-2 ml-2">
            Delete
          </v-btn>
        </div>
      </v-col>
    </v-row>
  </v-card>
  </router-link>
</template>

<script setup>

const { ticket } = defineProps({
    ticket:Object
}) 
</script>