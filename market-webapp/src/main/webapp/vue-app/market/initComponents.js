import Market from './components/Market.vue';

const components = {
  'market': Market,
};

for (const key in components) {
  Vue.component(key, components[key]);
}