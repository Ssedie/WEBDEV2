function Sidebar({isVisible}) {

    const menuItems = [
        {label: "Home", link: "/"},
        {label: "About", link: "/"},
        {label: "Services", link: "/"},
        {label: "Contact", link: "/"}
    ]
    return <div>
        <ul>
            {
                menuItems.map((item,index) => (<li key={index}>{item.label}</li>))
            }
        </ul>
    </div>
}

export default Sidebar
