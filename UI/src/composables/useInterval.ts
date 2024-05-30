import { onUnmounted, ref } from 'vue';

export function useInterval() {
  const intervals = ref([]);

  const setSafeInterval = (fn, ms) => {
    const interval = setInterval(fn, ms);
    intervals.value.push(interval);
    return interval;
  };

  const clearSafeInterval = (intervalId) => {
    clearInterval(intervalId);
    intervals.value = intervals.value.filter(id => id !== intervalId);
  };

  onUnmounted(() => {
    intervals.value.forEach(clearInterval);
  });

  return { setSafeInterval, clearSafeInterval };
}
