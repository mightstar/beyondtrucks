<template>
  <div>
    <h2>Student List</h2>
    <el-button type="primary" @click="openAddForm" style="margin-bottom: 10px">Add Student</el-button>
    <el-table :data="students" border style="width: 100%">
      <el-table-column prop="id" label="Student ID" width="150" />
      <el-table-column prop="name" label="Name" />
      <el-table-column prop="age" label="Age" width="100" />
      <el-table-column prop="sexuality" label="Sexuality" width="150" />
      <el-table-column label="Actions">
        <template #default="scope">
          <el-button
            size="mini"
            type="primary"
            @click="openEditForm(scope.row)"
          >
            Edit
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="confirmDelete(scope.row.id)"
          >
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <StudentForm
      :visible="formVisible"
      :student="formStudent"
      @submit="handleFormSubmit"
      @cancel="formVisible = false"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import { useStore } from 'vuex';
import StudentForm from '../components/StudentForm.vue';
import { deleteStudent } from '../services/studentService';

interface Student {
  id?: number;
  name: string;
  age: number | null;
  sexuality: string;
}

export default defineComponent({
  components: { StudentForm },
  setup() {
    const store = useStore();
    const formVisible = ref(false);
    const formStudent = ref<Student | null>(null); // Allow null initially
    const isEdit = ref(false);

    const fetchStudents = () => {
      store.dispatch('fetchStudents');
    };

    const openAddForm = () => {
      formStudent.value = { id: store.getters.students.length + 1, name: '', age: null, sexuality: '' };
      isEdit.value = false;
      formVisible.value = true;
    };

    const openEditForm = (student: Student) => {
      formStudent.value = { ...student };
      isEdit.value = true;
      formVisible.value = true;
    };

    const handleFormSubmit = async (student: Student) => {
      if (isEdit.value) {
        store.commit('updateStudent', student);
      } else {
        store.commit('addStudent', student);
      }
      formVisible.value = false;
    };

    const confirmDelete = async (id: number) => {
      try {
        await deleteStudent(id);
        store.commit('deleteStudent', id);
      } catch (error) {
        console.error('Error deleting student:', error);
      }
    };

    fetchStudents();

    return {
      students: store.getters.students,
      formVisible,
      formStudent,
      openAddForm,
      openEditForm,
      handleFormSubmit,
      confirmDelete,
    };
  },
});
</script>

<style scoped>
.el-button {
  margin-right: 10px;
}
</style>
