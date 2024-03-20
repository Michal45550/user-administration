import {useDispatch} from "react-redux";
import {useEffect} from "react";
import NewUser from "./components/newUser/NewUser.jsx";
import UserTable from "./components/userTable/UserTable.jsx";
import {GET_USERS_REQUESTED} from "./actions.js";


const UserAdmin = () => {

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch({type: GET_USERS_REQUESTED});
    }, [dispatch]);

    return (
        <div>
            <NewUser/>
            <UserTable/>
        </div>
    );
};

export default UserAdmin;
