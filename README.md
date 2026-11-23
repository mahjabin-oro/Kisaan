# Kisaan: A Smart Farming Assistant for Bangladeshi Farmers

**Kisaan** ("farmer") is an Android app that puts simple **machine-learning tools for farming** in a farmer's pocket. Farmers can **diagnose plant diseases from a photo**, get **crop and fertilizer recommendations** from their soil and weather conditions, and **reach help** quickly.

<!-- Add screenshots here: home screen, disease detection result, crop prediction, fertilizer prediction -->

---

## The problem

Smallholder farmers often find out about crop diseases too late, choose crops that don't suit their soil, or use the wrong fertilizer. Expert advice is not always nearby. Kisaan aims to give them quick, data-driven guidance on a phone.

## Features

### 🌿 Plant disease detection (on-device AI)
- Take a photo of a leaf with the camera, or pick one from the gallery
- An image-classification model running **directly on the phone (TensorFlow Lite)** identifies the plant and its condition
- Recognises **30 classes across 9 crops**: apple, corn (maize), grape, orange, bell pepper, potato, soybean, squash and tomato. It can detect diseases such as late blight, early blight, black rot, common rust, leaf mold, powdery mildew, mosaic virus and citrus greening, and it can also tell when a leaf is healthy.
- Works without an internet connection

### 🌾 Crop recommendation
- The farmer enters soil nutrients (**nitrogen, phosphorus, potassium**), **temperature, humidity, pH and rainfall**
- A machine-learning model, served through a web API, suggests the **most suitable crop** for those conditions

### 🧪 Fertilizer recommendation
- The farmer enters **soil type** (black, clayey, loamy, red, sandy), **crop type**, temperature, humidity, moisture and N-P-K levels
- The model recommends a fertilizer (e.g., Urea, DAP, NPK 17-17-17, 14-35-14, 20-20-20, 28-28) and explains **what it contains and why it is used**

### 📞 Call for help
- Choose your **division** (Dhaka, Chittagong, Rajshahi, Khulna, Barisal, Sylhet, Rangpur, Mymensingh) and call the nearest help station from inside the app

### 🖼️ Share a problem
- Upload a photo with a question and contact details, so that others can see it and respond

### 📚 Agricultural articles
- "Must read for farmers": curated articles on farming practices

### 👤 Accounts
- Register and log in with email verification and password reset (Firebase Authentication)

## Tech stack

| Area | Technology |
|---|---|
| App | Android (Java + Kotlin) |
| On-device ML | TensorFlow Lite image classifier (224×224 input) |
| Recommendation models | ML models served through a REST API (called with Volley) |
| Backend | Firebase Authentication, Firestore, Realtime Database, Storage |
| UI | Material Components, RecyclerView, CardView, Navigation Drawer, Picasso |

## How it works

```
Leaf photo ──► TFLite model on the phone ──► disease / healthy label
Soil + weather values ──► crop-recommendation API ──► best crop
Soil type + crop + N-P-K + climate ──► fertilizer API ──► fertilizer + explanation
```

## Running the project

1. Clone the repository and check out the `master` branch.
2. Open the project in **Android Studio**.
3. Replace `app/google-services.json` with your own Firebase project's config, and enable Email/Password auth, Firestore, Realtime Database and Storage.
4. Run on an Android device. Disease detection works offline. Crop and fertilizer prediction need their API endpoints to be online.

<!-- Built as a System Development course project. Add team members, course and year here if you want. -->
