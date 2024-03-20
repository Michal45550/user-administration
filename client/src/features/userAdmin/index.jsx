import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import NewUserModal from "./components/newUserModal/NewUserModal.jsx";
import UserTable from "./components/userTable/UserTable.jsx";
import {GET_USERS_REQUESTED} from "./actions.js";
import loadingIcon from '../userAdmin/assets/Spinner-1s-200px.gif';


const UserAdmin = () => {

    const dispatch = useDispatch();

    const loading = useSelector(({UserAdmin}) => UserAdmin.loading);

    useEffect(() => {
        dispatch({type: GET_USERS_REQUESTED});
    }, [dispatch]);

    return (
        <div>
            <NewUserModal/>
            <UserTable/>
            {loading && <img src={loadingIcon} alt="Loading" width="50px" height="50px"/>}
        </div>
    );
};

export default UserAdmin;
