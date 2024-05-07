import { computed } from 'vue';

export const useTime = () => {
    
    function timeStampToDate(timestamp: string): string {
        console.log(timestamp);
        return new Date(parseInt(timestamp) * 1000).toLocaleString();
    }

    const currentHour = new Date().getHours();

    const slidingWindow = computed(() => {
        const items = Array.from({ length: 24 }, (_, index) => (index + currentHour) % 24 + ":00");
        return items;
    });

    return {timeStampToDate, slidingWindow}
}

