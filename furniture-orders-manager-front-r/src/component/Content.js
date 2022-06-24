import React from "react";
import {Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import {Furniture} from "./pages/Furniture";
import {Cutting} from "./pages/Cutting";
import {Order} from "./pages/Order";

const Content = () => {
    return (
        <div className="row">
            <h2>Content</h2>

            <div className="col-auto">
                <Routes>
                    <Route path="/" exact element={<Home/>}/>
                    <Route path="/furniture" exact element={<Furniture/>}/>
                    <Route path="/cuttings" exact element={<Cutting/>}/>
                    <Route path="/orders" exact element={<Order/>}/>
                </Routes>
            </div>
        </div>
    )
}

export default Content;