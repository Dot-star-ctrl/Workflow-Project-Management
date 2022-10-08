<template>
     <v-row class="mt-10 ma-2" no-gutters>
        <v-col class="text-center">
          <p>ID</p>
        </v-col>
        <v-col cols="6" class="text-center">
          <p>TITLE</p>
        </v-col>
        <v-col class="text-center">
          <p>ACTIONS</p>
        </v-col>
      </v-row>
      <div class="tickets pt-10">
        <WorkspaceListItem 
        v-for="ticket in tickets"
        :key="ticket.id"
        :ticket="ticket"
        />
      </div>
</template>

<script setup>
import WorkspaceListItem from "@/components/Workspace/WorkspaceListItem.vue";

const tickets = [
  {
    id: 23,
    title: "Candidates tab not working",
    type: "Software related",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 days ago",
    updatedAt: "2 mins ago",
  },
    {
    id: 24,
    title: "I am unable to submit my registration",
    type: "Software related",
    description: "I am unable to submit my registration in the register as candidate tab",
    priority: "Medium",
    staus: "Open",
    createdAt: "2 days ago",
    updatedAt: "2 days ago",
  },
    {
    id: 25,
    title: "How I am supposed to apply for a position?",
    type: "",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 hours ago",
    updatedAt: "30 mins ago",
  },
    {
    id: 26,
    title: "Candidates tab not working",
    type: "Software related",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 days ago",
    updatedAt: "2 mins ago",
  },
];
</script>