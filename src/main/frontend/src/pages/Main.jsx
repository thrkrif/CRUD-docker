import { React, useEffect, useState } from "react";
import BoardList from "../components/BoardList/BoardList";
import axios from 'axios';
import { Link } from 'react-router-dom';
const Main = () => {
    const [data, setData] = useState([])

    // useEffect(() => {
    //     const getBoardList = async () => {
    //         console.log('getBoardList()');
    //         let response = await axios.get("/api/board-list");
    //         console.log('main/response: ', response);
    //         setData(response.data.data);
    //     };
    //     getBoardList();
    // }, [])
    useEffect(() => {
        const getBoardList = async () => {
            console.log('getBoardList()');
            try {
                // 절대 경로로 <-> 상대경로
                let response = await axios.get("/api/board-list");
                console.log('main/response: ', response);
                setData(response.data.data);
            } catch (error) {
                console.error('Error fetching data: ', error);
            }
        };
        getBoardList();  // 문제 없으면 여기에 await 추가 없이 호출해도 괜찮습니다
    }, [])

    return (
        <>

            <Link to={"/create-board"} >
                <input type='button' value='게시글 작성하기'/>
            </Link>
            <BoardList data={data}/>
        </>
    );
};
export default Main;