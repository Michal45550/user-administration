import {call, put, takeEvery} from 'redux-saga/effects'

import * as actions from './actions.js'

import * as api from './api.js';

function* getAllUsers() {
    yield put({type: actions.SET_LOADING});

    const allUsers = yield call(api.getAll);

    yield put({type: actions.GET_USERS, payload: allUsers});
}

function* createUser({payload}) {
    yield put({type: actions.SET_LOADING});

    const newUser = yield call(api.addUser, payload);

    yield put({type: actions.CREATE_USER, payload: newUser});
}

export default function* Sagas() {
    yield takeEvery(actions.GET_USERS_REQUESTED, getAllUsers)
    yield takeEvery(actions.CREATE_USER_REQUESTED, createUser)
}
