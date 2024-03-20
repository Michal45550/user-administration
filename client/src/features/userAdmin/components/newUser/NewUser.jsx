import {useState} from 'react';
import './NewUser.css';
import Modal from '@mui/material/Modal';
import {Box, FormControl, TextField} from "@mui/material";
import {useDispatch} from "react-redux";
import {CREATE_USER_REQUESTED} from "../../actions.js";

const NewUser = () => {

    const dispatch = useDispatch();

    const USER_DATA = {
        firstName: "",
        lastName: "",
        emailAddress: "",
        password: ""
    }

    const [open, setOpen] = useState(false);
    const [userData, setUserData] = useState(USER_DATA);

    const handleOpen = () => setOpen(true);
    const handleClose = () => {
        setOpen(false);
        setUserData(USER_DATA);
    }

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setUserData((prevProps) => ({
            ...prevProps,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch({
            type: CREATE_USER_REQUESTED,
            payload: userData
        });
        handleClose();
        setUserData(USER_DATA);
    }

    return (
        <div>
            <button className="add-button" onClick={handleOpen}>ADD USER</button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <div className="modal">
                    <div className="modal-header">
                        New user
                    </div>
                    <div className="modal-content">
                        <form onSubmit={handleSubmit}>

                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <TextField
                                        label="First name"
                                        name="firstName"
                                        variant="outlined"
                                        value={userData.firstName}
                                        required
                                        onChange={handleInputChange}
                                    />
                                </FormControl>
                            </Box>

                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <TextField
                                        label="Last name"
                                        name="lastName"
                                        variant="outlined"
                                        value={userData.lastName}
                                        required
                                        onChange={handleInputChange}
                                    />
                                </FormControl>
                            </Box>

                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <TextField
                                        label="Email address"
                                        name="emailAddress"
                                        variant="outlined"
                                        value={userData.emailAddress}
                                        required
                                        onChange={handleInputChange}
                                    />
                                </FormControl>
                            </Box>

                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <TextField
                                        label="Password"
                                        name="password"
                                        variant="outlined"
                                        value={userData.password}
                                        required
                                        onChange={handleInputChange}
                                    />
                                </FormControl>
                            </Box>

                            <button id="submit" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </Modal>
        </div>
    );
};

export default NewUser;
