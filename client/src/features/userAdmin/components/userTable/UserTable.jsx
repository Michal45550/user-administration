import {Table, TableContainer, TableHead, TableRow, TableCell, TableBody, Paper} from '@mui/material';
import {useDispatch, useSelector} from "react-redux";
import deleteIcon from '../../assets/delete.png';
import {DELETE_USER_REQUESTED} from "../../actions.js";

const UserTable = () => {

    const dispatch = useDispatch();

    const users = useSelector(({UserAdmin}) => UserAdmin.users);

    const columns = [{id: 'id', label: 'Id', minWidth: 100}, {
        id: 'firstName',
        label: 'First name',
        minWidth: 150
    }, {id: 'lastName', label: 'Last name', minWidth: 150}, {
        id: 'emailAddress',
        label: 'Email address',
        minWidth: 150
    }, {id: 'password', label: 'Password', minWidth: 150}];

    const handleDelete = (id) => {
        dispatch({type: DELETE_USER_REQUESTED, payload: id});
    }

    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        {columns.map((column) => (
                            <TableCell key={column.id} style={{minWidth: column.minWidth}}>
                                {column.label}
                            </TableCell>))}
                        <TableCell key={"empty"}></TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {users.length ? users.map((row, rowIndex) => (
                            <TableRow key={rowIndex}>
                                {columns.map((column) => (
                                    <TableCell key={column.id}>
                                        {row[column.id]}
                                    </TableCell>
                                ))}
                                <TableCell key={"delete"} onClick={() => handleDelete(row.id)}>
                                    <img src={deleteIcon}
                                         alt="Delete" width="30px"
                                         height="30px"/>
                                </TableCell>
                            </TableRow>))
                        : <TableRow>
                            <TableCell>no data</TableCell>
                        </TableRow>}
                </TableBody>
            </Table>
        </TableContainer>
    );
};

export default UserTable;
