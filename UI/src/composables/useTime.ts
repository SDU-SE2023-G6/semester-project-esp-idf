export const useTime = () => {
    
    function timeStampToDate(timestamp: string): string {
        console.log(timestamp);
        return new Date(parseInt(timestamp) * 1000).toLocaleString();
    }

    return {timeStampToDate}
}

