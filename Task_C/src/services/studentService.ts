import http from './httpService';

interface Student {
  id?: number;
  name: string;
  age: number;
  sexuality: string;
}

const endpoint = '/students';

export const getStudents = () => http.get(endpoint);
export const addStudent = (student: Student) => http.post(endpoint, student);
export const updateStudent = (id: number, student: Student) =>
  http.put(`${endpoint}/${id}`, student);
export const deleteStudent = (id: number) => http.delete(`${endpoint}/${id}`);
