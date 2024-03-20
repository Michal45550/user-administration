import {Provider} from 'react-redux'
import store from './store';
import UserAdmin from "./features/userAdmin/index.jsx";

const App = () => {

    return (
        <Provider store={store}>
            <UserAdmin/>
        </Provider>
    );
}

export default App;
