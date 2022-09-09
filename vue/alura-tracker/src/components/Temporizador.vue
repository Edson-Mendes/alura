<template>
  <div class="is-flex is-align-items-center is-justify-content-space-between">
    <Cronometro :tempoEmSegundos="tempoEmSegundos" />
    <Botao
      :isDisabled="cronometroRodando"
      :faIcon="'fas fa-play'"
      :text="'play'"
      @acao="iniciar"
    />
    <Botao
      :isDisabled="!cronometroRodando"
      :faIcon="'fas fa-stop'"
      :text="'stop'"
      @acao="finalizar"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Cronometro from "./Cronometro.vue";
import Botao from "./Botao.vue";

export default defineComponent({
  name: "Temporizador",
  emits: ["aoTemporizadorFinalizado"],
  data() {
    return {
      tempoEmSegundos: 0,
      cronometroId: 0,
      cronometroRodando: false,
    };
  },
  methods: {
    iniciar() {
      // Começar contagem
      this.cronometroRodando = true;
      this.cronometroId = setInterval(() => {
        this.tempoEmSegundos += 1;
      }, 1000);
    },
    finalizar() {
      clearInterval(this.cronometroId);
      this.cronometroRodando = false;
      this.$emit("aoTemporizadorFinalizado", this.tempoEmSegundos);
      this.tempoEmSegundos = 0;
    },
  },
  components: { Cronometro, Botao },
});
</script>
