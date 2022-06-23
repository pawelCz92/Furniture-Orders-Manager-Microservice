const Nav = () => {
    return (
        <>
            <p>Nav</p>
            <NavItem buttonText="Nav item 1"/>
            <NavItem buttonText="Nav item 2"/>
            <NavItem buttonText="Nav item 3"/>
        </>
    )
}

const NavItem = (props) => {
    return (
        <div className="row">
            <div className="col">
            <button className="btn btn-primary nav-btn">{props.buttonText}</button>
            </div>
        </div>
    )
}

export default Nav;