import {CREATE_USER, GET_USERS, SET_LOADING} from "./actions.js";

const initialState = {
    loading: false,
    users: [],
}

const Reducer = (state = initialState, {type, payload}) => {
    switch (type) {
        case SET_LOADING:
            return {
                ...state,
                loading: true
            }
        case GET_USERS:
            return {
                ...state,
                users: payload,
                loading: false
            }
        case CREATE_USER:
            return {
                ...state,
                users: [...state.users, payload],
                loading: false
            }
        default:
            return state;
    }
}

export default Reducer;
