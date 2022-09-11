<template>
  <header>
    <h1>
      <img src="../assets/logo.png" alt="logo alura tracker" />
    </h1>
    <BotaoIcone
      @acao="alterarTema"
      :icon="iconeClass"
      :estilo="'color: green;'"
    />
  </header>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import BotaoIcone from "./BotaoIcone.vue";

export default defineComponent({
  name: "BarraLateral",
  emits: ["aoTemaAlterado"],
  data() {
    return {
      modoEscuroAtivo: false,
    };
  },
  computed: {
    iconeClass() {
      if (this.modoEscuroAtivo) {
        return "fa-solid fa-moon";
      }
      return "fa-solid fa-sun";
    },
  },
  methods: {
    alterarTema() {
      this.modoEscuroAtivo = !this.modoEscuroAtivo;
      this.$emit("aoTemaAlterado", this.modoEscuroAtivo);
    },
  },
  components: { BotaoIcone },
});
</script>

<style>
header {
  background: #0d3b66;
  width: 100%;
  height: 100vh;
  padding: 1rem;
  text-align: center;
}

@media only screen and (max-width: 768px) {
  header {
    padding: 2.5rem;
    height: auto;
  }
}
</style>
