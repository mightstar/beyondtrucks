<template>
   <el-dialog v-model="localVisible" title="Student Form" @close="handleCancel">
    <el-form :model="localStudent" ref="form" label-width="120px">
      <el-form-item label="Name" prop="name">
        <el-input v-model="localStudent.name" />
      </el-form-item>
      <el-form-item label="Age" prop="age">
        <el-input-number v-model="localStudent.age" :min="1" />
      </el-form-item>
      <el-form-item label="Sexuality" prop="sexuality">
        <el-select v-model="localStudent.sexuality">
          <el-option label="Male" value="male" />
          <el-option label="Female" value="female" />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleCancel">Cancel</el-button>
      <el-button type="primary" @click="handleSubmit">Submit</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts">
import { defineComponent, ref, watch } from "vue";

export default defineComponent({
  props: {
    visible: {
      type: Boolean,
      required: true,
    },
    student: {
      type: Object as () => { name: string; age: number; sexuality: string },
      required: true,
    },
  },
  emits: ["submit", "cancel"],
  setup(props, { emit }) {
    const localVisible = ref(props.visible);
    const localStudent = ref({ ...props.student });

    watch(
      () => props.visible,
      (newValue) => {
        localVisible.value = newValue;
      }
    );

    watch(
      () => props.student,
      (newStudent) => {
        localStudent.value = { ...newStudent };
      }
    );

    const handleCancel = () => {
      emit("cancel");
    };

    const handleSubmit = () => {
      emit("submit", localStudent.value);
    };

    return {
      localVisible,
      localStudent,
      handleCancel,
      handleSubmit,
    };
  },
});
</script>
