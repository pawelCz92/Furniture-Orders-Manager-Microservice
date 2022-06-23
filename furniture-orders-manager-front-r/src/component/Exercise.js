import React from "react";
import axios from "axios";

export default class Exercise extends React.Component {

    state = {
        furniture: []
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/v1/furniture/").then(res => {
            const furniture = res.data;
            this.setState({furniture});
            console.log(res)
        })
    }

    render() {
        return (
            <>
                <hr/>
                <h1>hello</h1>
                <ul>
                    {
                        this.state.furniture
                            .map(fur =>
                                <li key={fur.name}>
                                <pre>
                                    {JSON.stringify(fur, null, 2)}
                                </pre>
                                </li>)
                    }
                </ul>
            </>
        )
    }
}


//  const fetchUserProfiles =  () => {
//       let endOfUrl = "";
//       axios.get("http://localhost:8080/api/v1/furniture/62a99ee5502d9914ecff7606" + endOfUrl).then(res => {
//           console.log(res);
//       });
