import React, { useEffect, useState } from "react";
import { getTest } from "../api/testApi";

const Home = () => {
    // test
    const [tests, setTests] = useState([]);

    useEffect(() => {
        getTest().then((res) => {
            console.log(res);
            setTests(res.data);
        });
    }, []);

    return (
        <div>
            <h1>dsg 월드에 오신 걸 환영합니다!</h1>
            <h2>오늘도 즐거운 하루 되세요!</h2>
            <br />
            <ul style={{ listStyle: "none" }}>
                {tests.map((item) => (
                    <li key={item.id}>{item.title}</li>
                ))}
            </ul>
        </div>
    );
};

export default Home;
