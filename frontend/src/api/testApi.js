import axios from "axios";

// .env 파일에 있는 AWS_EC2_IP_URL 값을 가져오기
const backendIpUrl = process.env.REACT_APP_BACKEND_IP_URL;

// 테스트 API 호출
export const getTest = async () => {
    console.log("backendIpUrl: ", backendIpUrl);
    const response = await axios.get(`${backendIpUrl}/api/test/list`);
    return response;
};
