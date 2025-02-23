/* JavaScript for Carousel */
document.addEventListener("DOMContentLoaded", function () {
    const carouselInner = document.querySelector(".carousel-inner");
    const items = document.querySelectorAll(".carousel-item");
    let currentIndex = 0;
    
    function updateCarousel() {
        const offset = -currentIndex * 100;
        carouselInner.style.transform = `translateX(${offset}%)`;
    }
    
    document.querySelector(".carousel-control-next").addEventListener("click", function () {
        currentIndex = (currentIndex + 1) % items.length;
        updateCarousel();
    });
    
    document.querySelector(".carousel-control-prev").addEventListener("click", function () {
        currentIndex = (currentIndex - 1 + items.length) % items.length;
        updateCarousel();
    });
    
    setInterval(() => {
        currentIndex = (currentIndex + 1) % items.length;
        updateCarousel();
    }, 5000);
});
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".play-button").forEach(button => {
        button.addEventListener("click", () => {
            alert("Playing Trailer...");
        });
    });
});
document.querySelectorAll('.movie-card').forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.boxShadow = '0 0 20px rgba(255, 165, 0, 0.7)'; // Orange glow
    });
    card.addEventListener('mouseleave', () => {
        card.style.boxShadow = 'none'; // Remove glow
    });
});