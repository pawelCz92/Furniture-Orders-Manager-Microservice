import React from "react";
import {Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import FurnitureMain from "./pages/furniture-page/FurnitureMain";
import {Cutting} from "./pages/Cutting";
import {Order} from "./pages/Order";

const Content = () => {
    return (
        <div className="row">
            <div className="col-auto content-content">
                <Routes>
                    <Route path="/" exact element={<Home/>}/>
                    <Route path="/furniture" exact element={<FurnitureMain/>}/>
                    <Route path="/cuttings" exact element={<Cutting/>}/>
                    <Route path="/orders" exact element={<Order/>}/>
                </Routes>
            </div>
        </div>
    )
}

export default Content;