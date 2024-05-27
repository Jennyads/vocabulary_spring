<template>
  <div class="about">
    <h1>Entregas</h1>
    <p><label for="descricao">Descrição: </label><input id="descricao" type="text" v-model="entrega.descricao"/></p>
    <p><label for="dataHoraLimite">Data/hora limite: </label><input id="dataHoraLimite" type="datetime-local" v-model="entrega.dataHoraLimite"/></p>
    <p><label for="peso">Peso: </label><input id="peso" type="number" v-model="entrega.peso"/></p>
    <p><label for="observacoes">Observações: </label><input id="observacoes" type="text" v-model="entrega.observacoes"/></p>
    <button @click="buscarEntregas">Atualizar</button>
    <button @click="incluir">Incluir</button>
    <p>{{ erro }}</p>
    <table>
      <thead>
        <td>Id</td>
        <td>Descrição</td>
        <td>Data/hora limite</td>
        <td>Peso</td>
      </thead>
      <tbody>
        <tr v-for="entrega in entregas" :key="entrega.id">
          <td>{{ entrega.id }}</td>
          <td>{{ entrega.descricao }}</td>
          <td>{{ entrega.dataHoraLimite }}</td>
          <td>{{ entrega.peso }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref } from 'vue';
  import axios from 'axios';
  
  const entrega = ref(
    {
      descricao: '',
      dataHoraLimite: Date.now(),
      peso: 1,
      observacoes: ''
    });
  const entregas = ref();
  const erro = ref("");

  async function incluir() {
    erro.value = "";
    try{
      await axios.post("entrega", entrega.value);
    }
    catch(e) {
      erro.value = (e as Error).message;
    }
    buscarEntregas();
  }

  async function buscarEntregas() {
    entregas.value = (await axios.get("entrega")).data;
  }

  onMounted(() => {
    buscarEntregas();
  });
</script>