import React from "react";
import {NavLink} from "react-router-dom";


const Sidebar = () => {
    return (
        <>
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
                <NavLink to={props.item.path} exact={props.item.exact ? props.item.exact : 'false'}>
                    <button className="btn btn-primary nav-btn">{props.item.title}</button>
                </NavLink>
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