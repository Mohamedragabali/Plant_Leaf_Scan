package com.mohamedragabali.plantleafscan.domain.data

import com.mohamedragabali.plantleafscan.R

object DataSource {
    private const val NUMBER_OF_NEEDED_ADVICE = 4
    fun allAdvice() = listOf(
        "Water your plants regularly, but avoid overwatering to prevent root rot issues.",
        "Place plants in appropriate lighting conditions for their specific species' growth requirements.",
        "Ensure proper drainage in pots to prevent water logging and promote healthy root development.",
        "Use quality potting soil that matches the needs of your plant type for best results.",
        "Fertilize plants periodically with the right nutrients to encourage vigorous growth and flowering.",
        "Prune dead or yellowing leaves to encourage new growth and maintain plant health.",
        "Rotate potted plants periodically to ensure even light exposure and balanced growth.",
        "Monitor for pests and diseases regularly, treating them promptly to prevent spread.",
        "Group plants with similar care requirements together to simplify watering and maintenance routines.",
        "Mist tropical plants occasionally to maintain humidity levels and keep leaves looking fresh.",
        "Repot plants annually or when roots outgrow their containers to encourage growth.",
        "Keep leaves clean by gently wiping with a damp cloth to remove dust.",
        "Provide support for climbing plants with stakes or trellises to help them grow upright.",
        "Avoid placing plants near drafts or vents to prevent stress and damage.",
        "Check soil moisture with a finger test before watering to avoid overwatering."
    )


    fun getFourRandomAdvice() = allAdvice().shuffled().take(NUMBER_OF_NEEDED_ADVICE)


    fun getPlantDiseaseHasText(text: String) =
        allDisease().filter { it.second.contains(text, ignoreCase = true) }

    private fun allDisease() = listOf(
        Pair(R.drawable.apple_scab, "Apple scab"),
        Pair(R.drawable.apple_black_rot, "Apple Black rot"),
        Pair(R.drawable.apple_cedar_rust, "Apple Cedar rust"),
        Pair(R.drawable.apple_healthy, "Apple healthy"),
        Pair(R.drawable.blueberry_healthy, "Blueberry healthy"),
        Pair(
            R.drawable.cherry_including_sour_powdery_mildew,
            "Cherry (including_sour) Powdery mildew"
        ),
        Pair(R.drawable.cherry_including_sour_healthy, "Cherry (including_sour) healthy"),
        Pair(R.drawable.grape_black_rot, "Grape Black_rot"),
        Pair(R.drawable.grape_esca_black_measles, "Grape Esca (Black Measles)"),
        Pair(R.drawable.grape_leaf_blight_spot, "Grape Leaf blight (Isariopsis Leaf Spot)"),
        Pair(R.drawable.grape_healthy, "Grape healthy"),
        Pair(
            R.drawable.orange_haunglongbing_citrus_greening,
            "Orange Haunglongbing (Citrus_greening)"
        ),
        Pair(R.drawable.peach_bacterial_spot, "Peach Bacterial spot"),
        Pair(R.drawable.peach_healthy, "Peach healthy"),
        Pair(R.drawable.pepper_bell_bacterial_spot, "Pepper bell Bacterial spot"),
        Pair(R.drawable.pepper_bell_healthy, "Pepper bell healthy"),
        Pair(R.drawable.potato_early_blight, "Potato Early blight"),
        Pair(R.drawable.potato_late_blight, "Potato Late blight"),
        Pair(R.drawable.potato_healthy, "Potato healthy"),
        Pair(R.drawable.raspberry_healthy, "Raspberry healthy"),
        Pair(R.drawable.soybean_healthy, "Soybean healthy"),
        Pair(R.drawable.squash_powdery_mildew, "Squash Powdery mildew"),
        Pair(R.drawable.strawberry_leaf_scorch, "Strawberry Leaf scorch"),
        Pair(R.drawable.strawberry_healthy, "Strawberry healthy"),
        Pair(R.drawable.tomato_bacterial_spot, "Tomato Bacterial spot"),
        Pair(R.drawable.tomato_early_blight, "Tomato Early blight"),
        Pair(R.drawable.tomato_late_blight, "Tomato Late blight"),
        Pair(R.drawable.tomato_leaf_mold, "Tomato Leaf Mold"),
        Pair(R.drawable.tomato_septoria_leaf_spot, "Tomato Septoria leaf_spot"),
        Pair(
            R.drawable.tomato_spider_mites_two_spotted_spider_mite,
            "Tomato Spider mites Two spotted spider mite"
        ),
        Pair(R.drawable.tomato_target_spot, "Tomato Target Spot"),
        Pair(R.drawable.tomato_yellow_leaf_curl_virus, "Tomato Yellow Leaf Curl Virus"),
        Pair(R.drawable.tomato_mosaic_virus, "Tomato mosaic virus"),
        Pair(R.drawable.tomato_healthy, "Tomato healthy")
    )

    fun diseaseTreatment(diseaseName: String) = listOf(
        Pair("Apple scab", "Use fungicides and practice proper sanitation."),
        Pair("Apple Black rot", "Remove infected fruit and apply fungicides."),
        Pair("Apple Cedar rust", "Apply fungicides and remove nearby junipers."),
        Pair("Apple healthy", "Maintain proper care and regular inspections."),
        Pair("Blueberry healthy", "Ensure proper watering and soil conditions."),
        Pair("Cherry (including_sour) Powdery mildew", "Apply sulfur or fungicides."),
        Pair("Cherry (including_sour) healthy", "Maintain proper care and regular inspections."),
        Pair("Grape Black_rot", "Use fungicides and remove infected parts."),
        Pair("Grape Esca (Black Measles)", "Prune infected areas and apply fungicides."),
        Pair(
            "Grape Leaf blight (Isariopsis Leaf Spot)",
            "Apply fungicides and improve air circulation."
        ),
        Pair("Grape healthy", "Ensure proper watering and pruning practices."),
        Pair("Orange Haunglongbing (Citrus_greening)", "Remove and destroy infected trees."),
        Pair("Peach Bacterial spot", "Apply copper-based bactericides."),
        Pair("Peach healthy", "Maintain proper care and regular inspections."),
        Pair("Pepper bell Bacterial spot", "Use resistant varieties and copper sprays."),
        Pair("Pepper bell healthy", "Ensure proper watering and soil conditions."),
        Pair("Potato Early blight", "Apply fungicides and practice crop rotation."),
        Pair("Potato Late blight", "Use resistant varieties and fungicides."),
        Pair("Potato healthy", "Maintain proper care and regular inspections."),
        Pair("Raspberry healthy", "Ensure proper watering and soil conditions."),
        Pair("Soybean healthy", "Practice crop rotation and proper soil care."),
        Pair("Squash Powdery mildew", "Apply fungicides and ensure good air circulation."),
        Pair("Strawberry Leaf scorch", "Remove infected leaves and apply fungicides."),
        Pair("Strawberry healthy", "Maintain proper care and regular inspections."),
        Pair("Tomato Bacterial spot", "Use copper-based sprays and resistant varieties."),
        Pair("Tomato Early blight", "Apply fungicides and remove infected leaves."),
        Pair("Tomato Late blight", "Use resistant varieties and fungicides."),
        Pair("Tomato Leaf Mold", "Ensure good air circulation and apply fungicides."),
        Pair("Tomato Septoria leaf_spot", "Remove infected leaves and apply fungicides."),
        Pair(
            "Tomato Spider mites Two spotted spider mite",
            "Use miticides and ensure proper watering."
        ),
        Pair("Tomato Target Spot", "Apply fungicides and ensure good air circulation."),
        Pair("Tomato Yellow Leaf Curl Virus", "Remove infected plants and control whiteflies."),
        Pair("Tomato mosaic virus", "Remove infected plants and disinfect tools."),
        Pair("Tomato healthy", "Maintain proper care and regular inspections.")
    ).filter { it.first == diseaseName }.first()
}