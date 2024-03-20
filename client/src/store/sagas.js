import {spawn} from 'redux-saga/effects'
import userAdminSaga from '../features/userAdmin/sagas'

export default function* rootSaga() {
    yield spawn(userAdminSaga);
}
