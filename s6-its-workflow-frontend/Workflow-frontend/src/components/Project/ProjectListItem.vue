<template>
  <router-link
    :to="{ name: 'ProjectView', params: { projectid: project.id } }"
    class="text-decoration-none"
  >
    <v-card max-width="344" class="ma-3">
      <v-card-text>
        <p class="text-h4 text--primary">{{project.id + ". " + project.title}}</p>
        <br />
        <div class="text--primary">
          relating to or dependent on charity; charitable.<br />
          "an eleemosynary educational institution."
        </div>
      </v-card-text>
      <v-card-actions>
        <v-progress-linear
          model-value="20"
          color="light-green darken-4"
          height="15"
          striped
        >
          <template v-slot:default="{ value }">
            <strong>{{ Math.ceil(value) }}%</strong>
          </template>
        </v-progress-linear>
      </v-card-actions>

      <v-expand-transition>
        <v-card
          v-if="reveal"
          class="transition-fast-in-fast-out v-card--reveal"
          style="height: 100%"
        >
          <v-card-text class="pb-0">
            <p class="text-h4 text--primary">Origin</p>
            <p>
              late 16th century (as a noun denoting a place where alms were
              distributed): from medieval Latin eleemosynarius, from late Latin
              eleemosyna ‘alms’, from Greek eleēmosunē ‘compassion’
            </p>
          </v-card-text>
          <v-card-actions class="pt-0">
            <v-btn variant="text" color="teal-accent-4" @click="reveal = false">
              Close
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-expand-transition>
    </v-card>
  </router-link>
</template>

<script setup>
defineProps({
  project: Object,
});
</script>