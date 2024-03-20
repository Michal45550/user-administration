import {Table, TableContainer, TableHead, TableRow, TableCell, TableBody, Paper} from '@mui/material';
import {useSelector} from "react-redux";

const UserTable = () => {

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

    return (
        users.length ? <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        {columns.map((column) => (<TableCell key={column.id} style={{minWidth: column.minWidth}}>
                            {column.label}
                        </TableCell>))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {users.map((row, rowIndex) => (<TableRow key={rowIndex}>
                        {columns.map((column) => (<TableCell key={column.id}>{row[column.id]}</TableCell>))}
                    </TableRow>))}
                </TableBody>
            </Table>
        </TableContainer> : "no data"
    );
};

export default UserTable;
