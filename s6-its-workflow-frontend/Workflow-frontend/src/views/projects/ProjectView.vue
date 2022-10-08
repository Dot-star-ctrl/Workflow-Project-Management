<template>
  <PageComponent title="Project" icon-name="fas fa-solid fa-list-check">
    <div>
      <div class="d-flex mt-10 align-center">
        <h2>Tasks</h2>
        <v-spacer></v-spacer>
        <v-dialog v-model="store.dialog" persistent class="create-task-dialog">
          <template v-slot:activator="{ props }">
            <v-btn
              rounded="outlined"
              color="#7d4e9a"
              class="new-task text-white mt-2"
              id="new-task"
              v-bind="props"
            >
              New Task
            </v-btn>
          </template>
          <v-card>
            <v-form ref="form" @submit.prevent="saveTask" lazy-validation>
              <v-card-title>
                <span class="text-h5">{{
                  store.currentTask.taskId > 0 ? "Edit Task" : "Create New Task"
                }}</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12">
                      <v-text-field
                        id="task-title"
                        v-model="store.currentTask.title"
                        label="Title*"
                        variant="outlined"
                        :rules="[(v) => !!v || 'Title is required']"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-text-field
                        label="Assignee*"
                        :disabled="true"
                        variant="outlined"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6">
                      <v-select
                        id="task-status"
                        v-model="store.currentTask.status"
                        :items="['To do', 'In progress', 'Done']"
                        label="Status*"
                        variant="outlined"
                        required
                      ></v-select>
                    </v-col>
                    <v-col cols="12" sm="6">
                      <Datepicker
                        :enableTimePicker="false"
                        v-model="store.currentTask.deadline"
                        :format="format"
                        label="asd"
                        class="datepicker"
                      />
                    </v-col>
                    <v-col cols="12">
                      <v-textarea
                        id="task-description"
                        v-model="store.currentTask.description"
                        label="Description*"
                        variant="outlined"
                        :rules="[(v) => !!v || 'Description is required']"
                        required
                      ></v-textarea>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  id="save-task"
                  color="blue-darken-1"
                  text
                  @click="
                    closeDialog();
                    clearCurrentTask();
                  "
                >
                  Close
                </v-btn>
                <v-btn color="blue-darken-1" text type="submit"> Save </v-btn>
              </v-card-actions>
            </v-form>
          </v-card>
        </v-dialog>
      </div>
      <TasksList />
    </div>
  </PageComponent>
</template>

<script setup>
import PageComponent from "@/layouts/PageComponent.vue";
import TasksList from "@/components/Task/TasksList.vue";
import { ref, onMounted } from "vue";
import Datepicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import { useTaskStore } from "@/stores/taskStore.js";

const store = useTaskStore();

let dialog = ref(false);

onMounted(() => {
  store.getTasksByProjectId(1);
});

let model = ref({
  taskId: 0,
  title: "",
  description: "",
  projectId: 1,
  status: "To do",
  assigneeId: 1,
  createdBy: "",
  deadline: "",
});

const date = ref(new Date());

const format = (date) => {
  const day = date.getDate();
  const month = date.getMonth() + 1;
  const year = date.getFullYear();

  return `Selected date is ${day}-${month}-${year}`;
};

const closeDialog = () => {
  store.dialog = false;
};

const clearCurrentTask = () => {
  store.setCurrentTask(model.value);
};

const saveTask = () => {
  store.saveTask();
  store.dialog = false;
  clearCurrentTask;
};
</script>

<style>
.dp__input {
  height: 57px;
  border: 1px solid;
}
</style>
