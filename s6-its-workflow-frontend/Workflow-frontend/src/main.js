import { createApp } from 'vue'
import App from '@/App.vue'
import router from '@/router'
import vuetify from '@/plugins/vuetify'
import { loadFonts } from '@/plugins/webfontloader'
import { createAuth0 } from '@auth0/auth0-vue';
import { createPinia } from 'pinia'

loadFonts()

createApp(App)
  .use(router)
  .use(createPinia())
  .use(vuetify)
  .use(
    createAuth0({
      // domain: import.meta.env.VUE_APP_AUTH0_DOMAIN,
      // client_id: import.meta.env.VUE_APP_AUTH0_CLIENT_ID,
      domain: "dev-ayl073mp.us.auth0.com",
      client_id: "SsnnjkdPI7KJZoJxg2J1E7mwNOsz0Gko",
      redirect_uri: window.location.origin,
      // audience: import.meta.env.VUE_APP_AUTH0_AUDIENCE
    })
  )
  .mount('#app')
