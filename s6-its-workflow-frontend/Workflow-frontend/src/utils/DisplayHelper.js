import { computed } from "vue";
import { useDisplay } from "vuetify";


export let showAppBar = computed(() => {
  const display = useDisplay();
  return display.mobile.value;
});

