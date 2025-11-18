function Header() {
    return (
        <header className="header">
            <button className="sidebar-toggle" onClick={toggleSidebar}>
                ☰
            </button>
            <h1>Zed's React App</h1>
            <div className="navigation-bar">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/services">Services</a></li>
                </ul>
            </div>
        </header>
    );
}

export default Header;
