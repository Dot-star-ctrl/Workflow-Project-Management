<template>
  <v-expansion-panel>
    <v-expansion-panel-title id="task-panel">
      <v-row>
        <v-col class="ticket-id text-center">
          <p>{{ task.taskId }}</p>
        </v-col>
        <v-col class="ticket-title text-center">
          <p>{{ task.title }}</p>
        </v-col>
        <v-col class="ticket-title text-center">
          <p>{{ task.status }}</p>
        </v-col>
        <v-col class="ticket-title text-center">
          <p>{{ task.deadline || "Not deadline" }}</p>
        </v-col>
        <v-col class="ticket-title text-center">
          <p>John Doe</p>
        </v-col>
      </v-row>
    </v-expansion-panel-title>
    <v-expansion-panel-text>
      <div class="d-flex align-center">
        <h4 class="mb-3 mt-3 mr-5">Created By</h4>
        <p class="mr-5">Stan Smith</p>
        <h4 class="mb-3 mt-3 mr-5">Created On</h4>
        <p>30/05/2022</p>
      </div>
      <h4 class="mb-3 mt-3">Description</h4>
      {{ task.description }}
      <div class="d-flex align-center">
        <v-spacer></v-spacer>
        <v-btn
          id="edit-task"
          rounded="outlined"
          color="#7d4e9a"
          class="mt-2 mr-4"
          @click="editTask"
          variant="outlined"
        >
          Edit
        </v-btn>
        <v-dialog v-model="dialog" persistent>
          <template v-slot:activator="{ props }">
            <v-btn
              id="delete-task"
              rounded="outlined"
              color="#7d4e9a"
              class="text-white mt-2"
              v-bind="props"
            >
              Delete
            </v-btn>
          </template>
          <v-card class="delete-task-card">
              <v-card-title>
                <span class="text-h5">Delete Task</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <p>Are you sure you want to delete this task?</p>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue-darken-1" text @click="closeDialog">
                  Cancel
                </v-btn>
                <v-btn color="blue-darken-1" id="confirm-delete-task" text @click="deleteTask">
                  Delete
                </v-btn>
              </v-card-actions>
          </v-card>
        </v-dialog>
      </div>
    </v-expansion-panel-text>
  </v-expansion-panel>
</template>

<script setup>
import { useTaskStore } from "@/stores/taskStore.js";
import { ref } from "vue";


const props = defineProps({
  task: Object,
});

let dialog = ref(false);
const store = useTaskStore();

const closeDialog = () => {
  dialog.value = false;
};

const editTask = () => {
  store.setCurrentTask(props.task);
  store.dialog = true;
};

const deleteTask = () => {
  store.deleteTask(props.task.taskId);
  closeDialog();
};
</script>
