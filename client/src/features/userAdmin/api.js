import defaultAxios from 'axios'
import {SERVICE_URL} from "../../const.js";

export const axiosInstance = defaultAxios.create({
    baseURL: SERVICE_URL,
    headers: {'Content-Type': 'application/json'}
});

export const getAll = async () => {
    try {
        const allUsers = await axiosInstance.get('users');
        return allUsers.data;
    } catch (err) {
        return console.error(err);
    }
}

export const addUser = async (user) => {
    try {
        const newUser = await axiosInstance.post('users', JSON.stringify(user));
        return newUser.data;
    } catch (err) {
        return console.error(err);
    }
}
