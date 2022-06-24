import React from "react";
import {Link} from "react-router-dom";
import {Furniture} from "./pages/Furniture";


const Sidebar = () => {
    return (
        <>
            <p>Sidebar</p>

            {sidebarData.map((item) => {
                return (<NavItem item={item} key={item.title}/>)
            })}
        </>
    )
}

const NavItem = (props) => {
    return (
        <div className="row">
            <div className="col">
                <Link to={props.item.path} exact={props.item.exact ? "true" : "false"}>
                    <button className="btn btn-primary nav-btn">{props.item.title}</button>
                </Link>
            </div>
        </div>
    )
}

const sidebarData = [
    {
        title: "Home",
        path: '/',
        exact: true
    },
    {
        title: 'Furniture',
        path: '/furniture'
    },
    {
        title: 'Cuttings',
        path: '/cuttings'
    },
    {
        title: 'Orders',
        path: '/orders'
    }
];

export default Sidebar;