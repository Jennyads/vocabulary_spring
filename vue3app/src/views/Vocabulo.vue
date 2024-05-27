<template>
    <div class="about">
      <h1>Gerencie Vocábulos </h1>
      <p><label for="termo">Termo: </label><input id="termo" type="text" v-model="vocabulo.termo"/></p>
      <p><label for="significado">Significado: </label><input id="significado" type="text" v-model="vocabulo.significado"/></p>
      <p><label for="versao">Versão: </label><input id="versao" type="number" v-model="vocabulo.versao"/></p>
      <p><label for="dataHoraCadastro">Data e Hora do Cadastro: </label><input id="dataHoraCadastro" type="datetime-local" v-model="vocabulo.dataHoraCadastro"/></p>
      <p><label for="dataHoraDesativacao">Data Desativação: </label><input id="dataHoraDesativacao" type="datetime-local" v-model="vocabulo.dataHoraDesativacao"/></p>
      <button @click="buscarVocabulos">Atualizar</button>
      <button @click="incluir">Incluir</button>
      <p>{{ erro }}</p>
      <table>
        <thead>
          <td>Id</td>
          <td>Termo</td>
          <td>Significado</td>
          <td>Versão</td>
          <td>Cadastro</td>
          <td>Desativação</td>
        </thead>
        <tbody>
          <tr v-for="vocabulo in vocabulos" :key="vocabulo.id">
            <td>{{ vocabulo.id }}</td>
            <td>{{ vocabulo.termo }}</td>
            <td>{{ vocabulo.significado }}</td>
            <td>{{ vocabulo.versao }}</td>
            <td>{{ vocabulo.dataHoraCadastro }}</td>
            <td>{{ vocabulo.dataHoraDesativacao}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script setup lang="ts">
    import { onMounted, ref } from 'vue';
    import axios from 'axios';
    
    const vocabulo = ref(
      {
        id: '',
        termo: '',
        significado: '',
        versao: null,
        dataHoraCadastro: Date.now(),
        dataHoraDesativacao: Date.now(),
      });

    const vocabulos = ref();
    const erro = ref("");
  
    async function incluir() {
      erro.value = "";
      try{
        await axios.post("vocabulo", vocabulo.value);
      }
      catch(e) {
        erro.value = (e as Error).message;
      }
      buscarVocabulos();
    }
  
    async function buscarVocabulos() {
      vocabulos.value = (await axios.get("vocabulo")).data;
    }
  
    onMounted(() => {
      buscarVocabulos();
    });
  </script>