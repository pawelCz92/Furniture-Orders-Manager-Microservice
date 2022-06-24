import React from "react";
import Header from "./component/Header"
import Content from "./component/Content";
import Footer from "./component/Footer";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Sidebar from "./component/Sidebar";


class App extends React.Component {
    render() {
        return (
            <div className="app-content">
                <div className='row header-content'>
                    <Header text="This is header of page"/>
                </div>

                <div className="row">
                    <div className='col-auto nav-content'>
                        <Sidebar/>
                    </div>
                    <div className='col-auto content-content'>
                        <Content/>
                    </div>
                </div>

                <div className='row footer-content'>
                    <Footer/>
                </div>
            </div>
        )
    }
}

export default App;