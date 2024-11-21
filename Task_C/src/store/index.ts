import { createStore } from 'vuex';

interface Student {
  id: number;
  name: string;
  age: number;
  sexuality: string;
}

export default createStore({
  state: {
    students: [] as Student[],
  },
  mutations: {
    setStudents(state, students: Student[]) {
      state.students = students;
    },
    addStudent(state, student: Student) {
      state.students.push(student);
    },
    updateStudent(state, updatedStudent: Student) {
      const index = state.students.findIndex((s) => s.id === updatedStudent.id);
      if (index !== -1) state.students.splice(index, 1, updatedStudent);
    },
    deleteStudent(state, id: number) {
      state.students = state.students.filter((s) => s.id !== id);
      console.log(333, state.students);
    },
  },
  actions: {
    fetchStudents({ commit }) {
      // Simulate API call
      const mockStudents = [
        { id: 1, name: 'John Doe', age: 20, sexuality: 'Male' },
        { id: 2, name: 'Jane Smith', age: 22, sexuality: 'Female' },
      ];
      commit('setStudents', mockStudents);
    },
  },
  getters: {
    students: (state) => state.students,
  },
  modules: {},
});
