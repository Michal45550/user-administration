import {configureStore} from '@reduxjs/toolkit'
import createSagaMiddleware from 'redux-saga'
import rootSaga from './sagas'
import UserAdminReducer from '../features/userAdmin/reducer';

const sagaMiddleware = createSagaMiddleware();

const store = configureStore({
    reducer: {
        UserAdmin: UserAdminReducer
    },
    middleware: [sagaMiddleware]
})


sagaMiddleware.run(rootSaga);

export default store;
