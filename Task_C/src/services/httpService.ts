import axios from 'axios';
import { ElMessage } from 'element-plus';

const http = axios.create({
  baseURL: 'http://localhost:3000/api',
  timeout: 5000,
});

http.interceptors.response.use(
  (response) => response.data,
  (error) => {
    ElMessage.error(error.response?.data?.message || 'Error occurred');
    return Promise.reject(error);
  }
);

export default http;
